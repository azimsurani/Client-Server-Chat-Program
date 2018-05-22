class Node {
  int freq;
  char key;
  Node left, right;
  public Node(int frequency,char ch)
  {
    freq=frequency;
    key = ch;
    left = right = null;
  }
}
class Main {
  public static void printCode(Node root,String str) {
    //POST ORDER TRAVERSAL
    if(root.left!=null)
      printCode(root.left,str+"0");
    if(root.right!=null)
      printCode(root.right,str+"1");
    if(root.key!='$')
      System.out.println(root.key+" : "+str);
  }
  public static void main(String[] args) {
    int[] freq = {2,3,5,7,10};
    char[] ch = {'a','b','c','d','e'};
    Node[] node = new Node[5];
    for(int i=0;i<5;i++) {
      node[i] = new Node(freq[i],ch[i]);
    }
    Node temp = new Node(0,'$');
    int m=4,n=5;
    while(m!=0) {
      for(int i = 0; i < m; i++) {
        for (int j = i+1; j < n; j++) {
          if (node[i].freq < node[j].freq) {
            temp=node[i];
            node[i]=node[j];
            node[j]=temp;
          }
        }
      }
      Node newNode = new Node(0,'$');
      newNode.freq = node[m-1].freq + node [n-1].freq;
      newNode.left = node[m-1];
      newNode.right = node[n-1];
      node [m-1] =newNode;
      n--;
      m--;
    }
    printCode(node[0],"");
  }
}
