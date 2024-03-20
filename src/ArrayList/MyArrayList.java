package ArrayList;

public class MyArrayList {
    private int numberOfElements;

   private String[] myArrayList = new String[5];
    private boolean isEmpty;

    public boolean isEmpty() {
        isEmpty = true;
        return numberOfElements == 0;
    }

    public void add(String element) {
        resizingArrayList();
        myArrayList[numberOfElements] = element;
        numberOfElements++;
    }

    private void resizingArrayList() {
        if(size() == myArrayList.length){
            String[] newArrayList = new String[myArrayList.length * 2];

            fillingUpOf(newArrayList);
            myArrayList = newArrayList;
        }
    }

    public void remove(int index) {
        myArrayList[index] = null;
        numberOfElements--;
    }

    public void add(int index, String element) {
        resizingArrayList();

        insert(index, element);
        myArrayList[index] = element;
        numberOfElements++;
    }

    private void fillingUpOf(String[] newArrayList) {
        for(int indexOfOldArrayList = 0; indexOfOldArrayList < myArrayList.length; indexOfOldArrayList ++)
            newArrayList[indexOfOldArrayList] = myArrayList[indexOfOldArrayList];

    }

    private void insert(int index, String element) {
        if(myArrayList[index] != null){
            String tempHolder = myArrayList[index];
            myArrayList[index] = element;
            myArrayList[index + 1] = tempHolder;
        }
    }

    public String get(int index) {
        String element = null;
        for(int arrayListIndex = 0; arrayListIndex < myArrayList.length; arrayListIndex++){
            if (index == arrayListIndex) element = myArrayList[index];

        }
        return element;
    }
    public int size() {
        return numberOfElements;
    }

    

}