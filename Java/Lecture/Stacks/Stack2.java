
public class Stack2<T>
{
    private class Node<T>
    {
        private T data;
        private Node<T> link;

        public Node( )
        {
             data = null;
             link = null;
        }

        public Node(T newData, Node<T> linkValue)
        {
            data = newData;
            link = linkValue;
        }
     }//End of Node<T> inner class

    private Node<T> top;

    public Stack2( )
    {
        top = null;
    }

    /**
     Adds a node at the start of the list with the specified data.
     The added node will be the first node in the list.
    */
    public void push(T itemData)
    {
        top = new Node<T>(itemData, top);
    }


    /**
     Removes the head node and returns true if the list contains at least
     one node. Returns false if the list is empty.
    */
    public T pop( )
    {
        T returnObj;      
        if (top != null){
            returnObj = top.data;
            top = top.link;
        }else{
            returnObj = null;
        }
        return returnObj;
    }

    /**
     Returns the number of nodes in the list.
    */
    public int size( )
    {
        int count = 0;
        Node<T> position = top;
        while (position != null)
        {
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(T item)
    {
        return (find(item) != null);
    }

    /**
     Finds the first node containing the target item, and returns a
     reference to that node. If target is not in the list, null is returned.
    */
    private Node<T> find(T target)
    {
        Node<T> position = top;
        T itemAtPosition;
        while (position != null)
        {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return position;
            position = position.link;
        }
        return null; //target was not found
    }

    /**
     Finds the first node containing the target and returns a reference
      to the data in that node. If target is not in the list, null is returned.
    */
    public T findData(T target)
    {
        return find(target).data;
    }

    public void outputList( )
    {
        Node<T> position = top;
        while (position != null)
        {
            System.out.println(position.data);
            position = position.link;
        }
    }

    public boolean isEmpty( )
    {
        return (top == null);
    }

    public void clear( )
    {
        top = null;
    }

   /*
    For two lists to be equal they must contain the same data items in
    the same order. The equals method of T is used to compare data items.
   */
   public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Stack2<T> otherList = (Stack2<T>)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node<T> position = top;
            Node<T> otherPosition = otherList.top;
            while (position != null)
            {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true; //no mismatch was not found
        }
    }

}
