package co.uk.deven.reviwer.reviwee.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReviewerRevieweeCode {
	private Map<String, GraphNode<String>> nodeMap = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		ReviewerRevieweeCode rrCode = new ReviewerRevieweeCode();
		rrCode.createMap();
		rrCode.printGraph();
	}

	private void createMap() throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("reviewers-and-reviewees.txt").getFile());
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String array[] = line.split("reviews");
			String reviewer = array[0].trim();
			String reviewee = array[1].trim();
			GraphNode<String> reviewerNode = nodeMap.get(reviewer);
			GraphNode<String> revieweeNode = nodeMap.get(reviewee);

			if (reviewerNode == null) {
				reviewerNode = new GraphNode<String>(reviewer);
				nodeMap.put(reviewer, reviewerNode);
			}
			if (revieweeNode == null) {
				revieweeNode = new GraphNode<String>(reviewee, reviewerNode);
				nodeMap.put(reviewee, revieweeNode);
			} else {
				revieweeNode.setParent(reviewerNode);
			}
			reviewerNode.addChild(revieweeNode);
		}
	}

	private void printGraph() throws FileNotFoundException {
		for (String key : nodeMap.keySet()) {
			if (nodeMap.get(key).isRoot()) {
				System.out.println(key);
			}
			if (nodeMap.get(key).isRoot()) {
				printChild(key, nodeMap.get(key), 0);
			}
		}
	}

	private String printChild(String key, GraphNode<String> child, int count) {
		if (nodeMap.get(key).getChildren() != null) {
			count++;
			for (GraphNode<String> child1 : nodeMap.get(key).getChildren()) {
				if (child1.getChildren().size() != 0) {
					System.out.println(rightPadding("", count) + child1.getData());
				} else {
					System.out.println(rightPadding("", count) + "\\-" + child1.getData());
				}
				printChild(child1.getData(), child1, count);
			}
		}
		return null;
	}

	private static String rightPadding(String str, int num) {
		return String.format("%1$-" + num + "s", str).replace(" ", "|");
	}

}
