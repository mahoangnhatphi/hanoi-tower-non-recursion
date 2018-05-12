package hanoitower;

import java.util.Stack;

class SavedStep {
	int disk;
	String fromTower;
	String toTower;
	String auxTower;

	public SavedStep() {
		// TODO Auto-generated constructor stub
	}

	public SavedStep(int disk, String fromTower, String toTower, String auxTower) {
		this.disk = disk;
		this.fromTower = fromTower;
		this.toTower = toTower;
		this.auxTower = auxTower;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Disk " + this.disk + " moves from " + this.fromTower + " to " + this.toTower;
	}

}

class StepStack {
	Stack<SavedStep> stack = new Stack<>();

	public void push(SavedStep savedStep) {
		stack.push(savedStep);
	}

	public SavedStep pop() {
		return stack.pop();
	}

	public SavedStep peek() {
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
}

public class HanoiTowerNonRecursion {

	public static void playHanoiTowerGame(int n, String fromTower, String toTower, String auxTower) {
		SavedStep firstStep = new SavedStep(n, fromTower, toTower, auxTower);
		StepStack stack = new StepStack();
		stack.push(firstStep);
		while (!stack.isEmpty()) {
			SavedStep top = stack.peek();
			if (top.disk == 1) {
				top = stack.pop();
				System.out.println(top);
				if (!stack.isEmpty()) {
					top = stack.pop();
					System.out.println(top);
					SavedStep nextStep = null;
					nextStep = new SavedStep(top.disk - 1, top.auxTower, top.toTower, top.fromTower);
					stack.push(nextStep);
				}
			} else {
				SavedStep nextStep = null;
				nextStep = new SavedStep(top.disk - 1, top.fromTower, top.auxTower, top.toTower);
				stack.push(nextStep);
			}
		}
	}

	public static void main(String[] args) {
		playHanoiTowerGame(3, "Tower 1", "Tower 3", "Tower 2");
	}
}
