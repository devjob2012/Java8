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
	private Map<String, NodeExample<String>> revieweeNodeMap = new HashMap<>();
	private Map<String, NodeExample<String>> reviewerNodeMap = new HashMap<>();
	private Map<String, NodeExample<String>> nodeMap = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		TreeMapExample tmEx = new TreeMapExample();
		tmEx.createMap();

	}

	// https://stackoverflow.com/questions/19330731/tree-implementation-in-java-root-parents-and-children
	private void useNode() throws FileNotFoundException {
		NodeExample<String> rootNode = new NodeExample<String>("ROOT");
		createMap();
		System.out.println(parentNodeMap.size());
		for (String reviwerer : parentNodeMap.keySet()) {

			if (childParentMap.get(reviwerer) != null) {
				// System.out.print(reviwerer + " ---> " +
				// parentNodeMap.get(reviwerer).getParent());
				// System.out.println("---> " + childParentMap.get(reviwerer).getData());
				parentNodeMap.get(reviwerer).setParent(childParentMap.get(reviwerer));

				// System.out.print(reviwerer + " ---> " +
				// parentNodeMap.get(reviwerer).getParent().getData());
				// System.out.println("---> " + childParentMap.get(reviwerer).getData());

			} else {
				System.out.println(reviwerer);
				System.out.println(reviewerRevieweeMap.get(reviwerer).size());

			}
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
			NodeExample<String> reviewerNode = nodeMap.get(reviewer);
			NodeExample<String> revieweeNode = nodeMap.get(reviewee);

			if (reviewerNode == null) {
				if(revieweeNode==null) {
					reviewerNode = new NodeExample<String>(reviewer);
					nodeMap.put(reviewer, reviewerNode);					
				}else {
					reviewerNode = nodeMap.get(reviewee);
				}
			}
			if (revieweeNode == null) {
				revieweeNode = new NodeExample<String>(reviewer, reviewerNode);
				nodeMap.put(reviewee, reviewerNode);
			} else {
				revieweeNode.setParent(reviewerNode);
			}

			
		}
		for (String key : nodeMap.keySet()) {
			System.out.print(key  +"      ----->  ");
			System.out.println(nodeMap.get(key).getParent());
			//System.out.println(nodeMap.get(key).isRoot());
		}
		return reviewerRevieweeMap;
	}
}
