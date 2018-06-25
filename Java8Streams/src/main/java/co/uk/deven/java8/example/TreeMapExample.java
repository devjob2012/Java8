package co.uk.deven.java8.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeMapExample {
	private Map<String, List<NodeExample<String>>> reviewerRevieweeMap = new HashMap<>();
	private Map<String, NodeExample<String>> childParentMap = new HashMap<>();
	private Map<String, NodeExample<String>> parentNodeMap = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		TreeMapExample tmEx = new TreeMapExample();
		tmEx.useNode();

	}

	// https://stackoverflow.com/questions/19330731/tree-implementation-in-java-root-parents-and-children
	private void useNode() throws FileNotFoundException {
		NodeExample<String> rootNode = new NodeExample<String>("ROOT");
		createMap();
		// for (String str : reviewerRevieweeMap.keySet()) {
		// NodeExample<String> node = new NodeExample<String>(str);
		// for (String child : reviewerRevieweeMap.get(str)) {
		// node.addChild(child);
		// if (childParentMap.get(str) != null) {
		// NodeExample<String> parent = new
		// NodeExample<String>(childParentMap.get(str));
		// node.setParent(parent);
		// }
		// }
		// }
		for (String key : childParentMap.keySet()) {
			while (childParentMap.get(key) != null) {
				key = childParentMap.get(key).getData();
				System.out.println(" --> " + key);
				if (childParentMap.get(key) != null) {
					System.out.println(childParentMap.get(key).getParent());
				}

				// for (NodeExample<String> node : reviewerRevieweeMap.get(key)) {
				// System.out.println(" "+node.getData());
				// }
				// System.out.println(reviewerRevieweeMap.get(key));
			}
			System.out.println(key);
		}
	}

	private Map<String, List<NodeExample<String>>> createMap() throws FileNotFoundException {
		File file = new File("/Users/devendra/Downloads/reviewers-and-reviewees.txt");
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String array[] = line.split("reviews");
			String reviewer = array[0].trim();
			String reviewee = array[1].trim();
			NodeExample<String> parentNode = new NodeExample<String>(reviewer);
			NodeExample<String> node = new NodeExample<String>(reviewee, parentNode);
			childParentMap.put(reviewee, parentNode);
			parentNodeMap.put(reviewer, parentNode);
			List<NodeExample<String>> lsReviewee = null;
			if (reviewerRevieweeMap.get(reviewer) == null) {
				lsReviewee = new ArrayList<>();
				lsReviewee.add(node);
				reviewerRevieweeMap.put(reviewer, lsReviewee);
			} else {
				lsReviewee = reviewerRevieweeMap.get(reviewer);
				lsReviewee.add(node);
				reviewerRevieweeMap.put(reviewer, lsReviewee);
			}
			if (parentNodeMap.get(reviewee) != null) {
				System.out.println(" reviewer " + reviewer + " reviewee " + reviewee);
				parentNodeMap.get(reviewee).setParent(parentNode);
			}
		}
		for (String str : reviewerRevieweeMap.keySet()) {
			//if (childParentMap.get(str) != null) {
				System.out.println(str + "------> " + str);
				for (NodeExample<String> str1 : reviewerRevieweeMap.get(str)) {
					System.out.println(str1.getData());
					if (parentNodeMap.get(str1.getData()) != null) {
						System.out.println(" reviewer " + str1.getData() );
						//parentNodeMap.get(reviewee).setParent(parentNode);
					}
				}
			//}

		}
		return reviewerRevieweeMap;
	}
}
