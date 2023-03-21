package tcs.interview.streamAPI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.GroupLayout.ParallelGroup;

public class FlatMapForTextFilesSplitWords {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("C:\\test\\test.txt");

		// read file into a stream of lines
		Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
		Stream<String> lines2 = Files.lines(path, StandardCharsets.UTF_8);

		// stream of array...hard to process.
		// Stream<String[]> words = lines.map(line -> line.split(" +"));

		// stream of stream of string....hmm...better flat to one level.
		// Stream<Stream<String>> words = lines.map(line -> Stream.of(line.split("
		// +")));

		// result a stream of words, good!
		Stream<String> words = lines.flatMap(x -> Stream.of(x.split(" +")));
		words.forEach(System.out::println);

		// count the number of words.
		long noOfWords = lines2.flatMap(n -> Stream.of(n.split(" +"))).count();

		System.out.println(noOfWords); // 16

	}
}
