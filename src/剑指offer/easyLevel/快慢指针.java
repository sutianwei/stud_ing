package 剑指offer.easyLevel;


import java.util.HashSet;
import java.util.Set;

/**
 * 链表是通过指针，将一组零散的内存块串起来，不需要连续的内存地址，链表中得每个节点，都保存里下一个节点的内存地址的指针。
 * 单链表
 * --->|data|next|--->|data|next|--->|data|next|--->null
 * 每个节点存在一个next节点，成为后续指针，next指针指向后一个节点，尾节点的next指针，指向null
 * 单向循环链表
 * :尾节点的next节点，指向头结点
 *
 * 双链表
 * ：在单链表的基础上，为每个节点增加一个pre节点，指向节点的前驱结点
 * --->|data|next|--->|data|next|--->|data|next|--->null
 *                <---           <---
 *
 * 双向循环链表
 * ：：双向循环链表基础上，头结点指向尾节点，尾节点指向头节点
 *
 */
class Node {

    public String  data;
    public Node next;

    public Node(){

    }
    public Node(String data) {
        this.data = data;

    }
}


public class 快慢指针 {

    /**
     * 快指针比慢指针快走4步，快指针到最后时，慢指针在最后的前四位，就是倒数第4个上
     * @param head
     * @param k
     * @return
     */
    public static Node  theK(Node head, int k){
        if (k<0)  return null;

        Node  fast=head;
        Node  slow=head;
        int i=k;
        //fast 快指针，先走K步
        for (;i>0 && fast !=null; i--){
            fast=fast.next;
        }
        //确保fast走完K步
        if (i>0) return null;
        while (fast !=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    /**
     * 获取中间值，fast每次移动两个，slow每次移动一个
     * @param head
     * @return
     */
    public static Node theMiddle(Node head){
        if (head == null) return  null;
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;
    }

    /**
     * 已知一个链表的head，判断当前链表是否有环
     * fast每次移动两个，slow每次移动一个，fast 和slow 最终会相遇
     *
     * @return
     */
    public static boolean ifCircle(Node head){

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return  true;
            }
        }
        return  false;
    }

    /**
     * 检测单链表的环的入口1
     *
     * 链表的环，意味着必然有一个后面的节点指向里前面的某个节点，从头到尾走，入口那个节点就会走两遍
     * 用set可以筛选出那个节点(hash法)
     */

    public  Node findCycle(Node head){
        Set<Node> saw = new HashSet<>();
        Node node = head;
        while (node != null){
            if (saw .contains(node))
                return  node;
            saw.add(node);
            node=node.next;
        }
         return  null;
    }

    /**
     * 检测单链表的环的入口2
     *
     *
     */

    public  static Node findCrcyle2(Node head){
        Node fast = head;
        Node slow = head;

        while (true){
            if (fast == null || fast.next == null)   return  null;
            slow = slow.next;
            fast = fast.next.next;
            if ( fast == slow)
                 break;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return  fast;
    }
}
