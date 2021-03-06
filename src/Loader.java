import java.io.IOException;

/**
 * An utility class responsible for loading the three corpora (learning, 
 * testing and the result generated by the application). 
 * @author Antoine Lafouasse
 *
 */
public class Loader
{
	/**
	 * Reads the program arguments and loads the learning, testing and result 
	 * corpora accordingly.
	 * @param args The program arguments.
	 * @throws IOException If any file-related error happens.
	 */
	public Loader(String[] args)
		throws IOException
	{
		if (args.length >= 1)
		{
			System.out.println("A path for the learning corpus was provided.");
			System.out.println("Loading: "+args[0]);
			this.learn = new FileHandler(args[0]);
			if (this.learn.isEmpty())
			{
				System.out.println("Error : this file is empty.");
				System.out.println("Reverting to default configuration");
				this.learn = new FileHandler(Loader.defaultLearn);
				System.out.println("Default learning corpus successfully " +
						"loaded.");
			}
			else
				System.out.println("Learning corpus successfully loaded.");
		}
		else
		{
			System.out.println("No path provided for the learning corpus.");
			System.out.println("Reverting to default configuration.");
			this.learn = new FileHandler(Loader.defaultLearn);
			System.out.println("Default learning corpus successfully " +
					"loaded.");
		}
		System.out.println();
		if (args.length >= 2)
		{
			System.out.println("A path for the testing corpus was provided.");
			System.out.println("Loading: "+args[1]);
			this.test = new FileHandler(args[1]);
			if (this.learn.isEmpty())
			{
				System.out.println("Error : this file is empty.");
				System.out.println("Reverting to default configuration.");
				this.test = new FileHandler(Loader.defaultTest);
				System.out.println("Default testing corpus successfully " +
						"loaded.");
			}
			else
				System.out.println("Testing corpus successfully loaded.");
		}
		else
		{
			System.out.println("No path provided for the testing corpus.");
			System.out.println("Reverting to default configuration.");
			this.test = new FileHandler(Loader.defaultTest);
			System.out.println("Default testing corpus successfully " +
					"loaded.");
		}
		System.out.println();
		if (args.length >= 3)
		{
			System.out.println("A path for the output corpus was provided.");
			this.result = new FileHandler(args[2]);
			System.out.println("Output corpus successfully loaded.");
		}
		else
		{
			System.out.println("No path provided for the output corpus.");
			System.out.println("Reverting to default configuration.");
			this.result = new FileHandler(Loader.defaultResult);
			System.out.println("Default output corpus successfully " +
					"loaded.");
		}
	}
	
	/**
	 * Returns the learning corpus previously loaded.
	 * @return An instance of FileHandler.
	 */
	public FileHandler getLearn()
	{
		return this.learn;
	}
	
	/**
	 * Returns the testing corpus previously loaded.
	 * @return An instance of FileHandler.
	 */
	public FileHandler getResult()
	{
		return this.result;
	}
	
	/**
	 * Returns the result corpus previously loaded.
	 * @return An instance of FileHandler.
	 */
	public FileHandler getTest()
	{
		return this.test;
	}
	
	/**
	 * The FileHandler for the learning corpus, loaded in the constructor.
	 */
	private FileHandler learn;
	
	/**
	 * The FileHandler for the result corpus, loaded in the constructor.
	 */
	private FileHandler result;
	
	/**
	 * The FileHandler for the testing corpus, loaded in the constructor.
	 */
	private FileHandler test;
	
	/**
	 * The default path to the learning corpus.
	 */
	private final static String defaultLearn = 
			"Corpus_train.project.java+algo.2013.txt";
	
	/**
	 * The defaut path to the result corpus.
	 */
	private final static String defaultResult = 
			"Corpus_result.project.java+algo.2013.txt";
	
	/**
	 * The default path to the testing corpus.
	 */
	private final static String defaultTest = 
			"Corpus_test.project.java+algo.2013.txt";
	
}
