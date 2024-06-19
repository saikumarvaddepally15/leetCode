class Node {
    // Stores the URL of the page
    String data;
    // Pointer to the next page in history
    Node next;
    // Pointer to the previous page in history
    Node back;

    // Default constructor
    Node() {
        data = "0";
        next = null;
        back = null;
    }

    // Constructor with data
    Node(String x) {
        data = x;
        next = null;
        back = null;
    }

    // Constructor with data and pointers
    Node(String x, Node next, Node random) {
        data = x;
        this.next = next;
        back = random;
    }
}



class BrowserHistory {
         Node currentpage;
    public BrowserHistory(String homepage) {
        currentpage=new Node(homepage);
    }
    
    public void visit(String url) {
        Node newnode= new Node(url);
        newnode.back=currentpage;
        currentpage.next=newnode;
        currentpage=newnode;
    }
    
    public String back(int steps) {
        while(steps>0 && currentpage.back!=null){
            currentpage=currentpage.back;
            steps--;
        }
        return currentpage.data;
    }
    
    public String forward(int steps) {
          while(steps>0 && currentpage.next!=null){
            currentpage=currentpage.next;
            steps--;
        }
        return currentpage.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */