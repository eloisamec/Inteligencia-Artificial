package tree;

import java.util.ArrayList;

public class Node {

	private String identifier;
	private ArrayList<String> children;

	public Node(String identifier) {
		this.identifier = identifier;
		children = new ArrayList<String>();
	}

	public String getIdentifier() {
		return identifier;
	}

	public ArrayList<String> getChildren() {
		return children;
	}

	public void addChild(String identifier) {
		children.add(identifier);
	}
}
