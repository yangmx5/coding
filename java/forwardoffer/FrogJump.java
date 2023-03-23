package forwardoffer;

public class FrogJump {

	/*
	 * 青蛙跳台阶问题:
	 * 青蛙可以跳任意高的台阶，求青蛙跳上一个n级的台阶总共有多少种跳法
	 * 每个台阶青蛙可以选择跳或不跳（最后一个台阶必须跳）
	 * 所以2^(n-1)种跳法
	 * 
	 */
	public int  JumpFloorInRecursion(int target){
		if(target <= 0){
			return -1;
		}else if(target == 1){
			return 1;
		}else{
			return 2*JumpFloorInRecursion(target-1); 
		}
	}
	
	public int JumpFloorInMath(int target){
		return (int)Math.pow(2,target-1);
	}
	
}
