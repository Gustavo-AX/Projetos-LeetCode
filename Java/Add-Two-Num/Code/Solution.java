
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode output = temp;

        //Esse while soma até o penúltima soma
        while(l1.next!=null || l2.next != null){
            int v1 = l1.val;
            int v2 = l2.val;

            if(l1.next==null){
            l1.next = new ListNode(0);
            }

            if(l2.next==null){
            l2.next = new ListNode(0);
            }

            int soma = v1 + v2 + temp.val;

            if(soma>9)
                temp.next = new ListNode(1);
            else
                temp.next = new ListNode(0);

            temp.val = soma%10;
            l1 = l1.next;
            l2 = l2.next;
            temp=temp.next;
        }

        //realizamos agora a ultima soma;
        int soma = l1.val + l2.val + temp.val;
        if(soma>9)
            temp.next = new ListNode(1);    
        temp.val = soma %10;
        return output;
    }
}

