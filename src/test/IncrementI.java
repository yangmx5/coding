package test;

class Node {
	public Integer i;
	public Node nextNode;

	Node(Integer i, Node nextNode) {
		this.i = i;
		this.nextNode = nextNode;
	}

}

/*
 * 不可变链表实现
 * 
 * 与普通i++操作对比
 * 
 */
public class IncrementI {

	public  static Node node = new Node(0, null);//链表头

	//每次创建一个新的值为1的节点放在链表头部
	public static  void Increment() {
		Node temp = new Node(1, node);
		node = temp;
	}

	//计算链表中的元素值得总和
	public static Integer getCount() {
		Integer result = 0;
		while (node != null) {
			result += node.i;
			node = node.nextNode;
		}

		return result;
	}

	public static Integer count = 0;

	public static void main(String[] args) {

//		for (int z = 0; z < 100; z++) {
//			
//			count = 0;
//			node = new Node(0, null);
//					
			for (int i = 0; i < 10000; i++) {
				new Thread() {
					public void run() {
						count++;
						Increment();
					};
				}.start();
			}

			System.out.println(count.toString() + "--" + getCount().toString());
//		}
	}
}
