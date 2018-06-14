package B_Mail;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;

import marytts.TextToSpeech;
import marytts.signalproc.effects.JetPilotEffect;
import net.sourceforge.javaflacencoder.FLACFileWriter;

/**
 * This is where all begins .
 * 
 * 
 *
 */
public class Application {

	private final TextToSpeech tts = new TextToSpeech();
	private final Microphone mic = new Microphone(FLACFileWriter.FLAC);
	private final GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	String oldText = "";
	static String output = "";

	/**
	 * Constructor
	 */
	public void Applications() {

		// Duplex Configuration
		duplex.setLanguage("en");

		duplex.addResponseListener(new GSpeechResponseListener() {

			public void onResponse(GoogleResponse googleResponse) {
				// String output = "";

				// Get the response from Google Cloud
				output = googleResponse.getResponse();
				System.out.println(output);
				if (output != null) {
					makeDecision(output);
				} else
					System.out.println("Output was null");
			}
		});

		// ---------------MaryTTS Configuration-----------------------------

		
		tts.setVoice("cmu-slt-hsmm");

		
		JetPilotEffect jetPilotEffect = new JetPilotEffect(); // epic fun!!!
		jetPilotEffect.setParams("amount:100");


		startSpeechRecognition();

	}

	/**
	 * This method makes a decision based on the given text of the Speech
	 * Recognition
	 * 
	 * @param text
	 */
	public void makeDecision(String output) {
		output = output.trim();
		// System.out.println(output.trim());

		// We don't want duplicate responses
		if (!oldText.equals(output))
			oldText = output;
		else
			return;

		
	}


	public void speak(String text) {
		System.out.println(text);
		// Check if it is already speaking
		if (!tts.isSpeaking())
			new Thread(() -> tts.speak(text, 2.0f, true, false)).start();

	}

	/**
	 * Starts the Speech Recognition
	 */
	public void startSpeechRecognition() {
		// Start a new Thread so our application don't lags
		new Thread(() -> {
			try {
				duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	/**
	 * Stops the Speech Recognition
	 */
	public void stopSpeechRecognition() {
		mic.close();
		System.out.println("Stopping Speech Recognition...." + " , Microphone State is:" + mic.getState());
	}

	public static void main(String[] args) {
		Application app = new Application();
		// app.Applications();
		index in = new index();
		in.findex();

	}

}
