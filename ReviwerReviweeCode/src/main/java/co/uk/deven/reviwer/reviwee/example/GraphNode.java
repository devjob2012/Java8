package co.uk.deven.reviwer.reviwee.example;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
	private List<GraphNode<T>> children = new ArrayList<GraphNode<T>>();
	private GraphNode<T> parent = null;
	private T data = null;

	public GraphNode(T data) {
		this.data = data;
	}

	public GraphNode(T data, GraphNode<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	public List<GraphNode<T>> getChildren() {
		return children;
	}

	public void setParent(GraphNode<T> parent) {
		this.parent = parent;
	}

	public GraphNode<T> getParent() {
		return this.parent;
	}

	public void addChild(T data) {
		GraphNode<T> child = new GraphNode<T>(data);
		child.setParent(this);
		this.children.add(child);
	}

	public void addChild(GraphNode<T> child) {
		child.setParent(this);
		this.children.add(child);
	}

	public T getData() {
		return this.data;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}
}