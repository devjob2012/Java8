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
	public static void main(String[] args) throws FileNotFoundException {
		TreeMapExample tmEx = new TreeMapExample();
		tmEx.useNode();
	}

	private void useNode() throws FileNotFoundException {

		Map<String, List<String>> map = createMap();
		for (String str : map.keySet()) {
			NodeExample<String> parentNode = new NodeExample<String>(str); 
			NodeExample<String> childNode = new NodeExample<String>(str,parentNode); 
		}

	}

	private Map<String, List<String>> createMap() throws FileNotFoundException {
		File file = new File("/Users/devenrawat/Downloads/reviewers-and-reviewees.txt");
		Scanner sc = new Scanner(file);
		Map<String, List<String>> reviewerRevieweeMap = new HashMap<>();		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String array[] = line.split("reviews");
			String reviewer = array[0];
			String reviewee = array[1];
			List<String> lsReviewee = null;
			if (reviewerRevieweeMap.get(reviewer) == null) {
				lsReviewee = new ArrayList<>();
				lsReviewee.add(reviewee);
				reviewerRevieweeMap.put(reviewer, lsReviewee);
			} else {
				lsReviewee = reviewerRevieweeMap.get(reviewer);
				lsReviewee.add(reviewee);
				reviewerRevieweeMap.put(reviewer, lsReviewee);
			}
		}

		return reviewerRevieweeMap;
	}
}

class Node {
	public String name;
	public List<Edge> connections;
}

class Graph {
	List<Node> nodes;
}

class Edge {
	public Node start;
	public Node end;
	public double weight;
}

class Tree<T> {

	private T head;

	private ArrayList<Tree<T>> leafs = new ArrayList<Tree<T>>();

	private Tree<T> parent = null;

	private HashMap<T, Tree<T>> locate = new HashMap<T, Tree<T>>();

	public Tree(T head) {
		this.head = head;
		locate.put(head, this);
	}

	public void addLeaf(T root, T leaf) {
		if (locate.containsKey(root)) {
			locate.get(root).addLeaf(leaf);
		} else {
			addLeaf(root).addLeaf(leaf);
		}
	}

	public Tree<T> addLeaf(T leaf) {
		Tree<T> t = new Tree<T>(leaf);
		leafs.add(t);
		t.parent = this;
		t.locate = this.locate;
		locate.put(leaf, t);
		return t;
	}

	public Tree<T> setAsParent(T parentRoot) {
		Tree<T> t = new Tree<T>(parentRoot);
		t.leafs.add(this);
		this.parent = t;
		t.locate = this.locate;
		t.locate.put(head, this);
		t.locate.put(parentRoot, t);
		return t;
	}

	public T getHead() {
		return head;
	}

	public Tree<T> getTree(T element) {
		return locate.get(element);
	}

	public Tree<T> getParent() {
		return parent;
	}

	public Collection<T> getSuccessors(T root) {
		Collection<T> successors = new ArrayList<T>();
		Tree<T> tree = getTree(root);
		if (null != tree) {
			for (Tree<T> leaf : tree.leafs) {
				successors.add(leaf.head);
			}
		}
		return successors;
	}

	public Collection<Tree<T>> getSubTrees() {
		return leafs;
	}

	public static <T> Collection<T> getSuccessors(T of, Collection<Tree<T>> in) {
		for (Tree<T> tree : in) {
			if (tree.locate.containsKey(of)) {
				return tree.getSuccessors(of);
			}
		}
		return new ArrayList<T>();
	}

	@Override
	public String toString() {
		return printTree(0);
	}

	private static final int indent = 2;

	private String printTree(int increment) {
		String s = "";
		String inc = "";
		for (int i = 0; i < increment; ++i) {
			inc = inc + " ";
		}
		s = inc + head;
		for (Tree<T> child : leafs) {
			s += "\n" + child.printTree(increment + indent);
		}
		return s;
	}
}