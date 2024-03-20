package set;

import java.util.ArrayList;

public class Set {

    public boolean isEmpty() {
        return this.numberOfElements == 0;
    }

    public boolean add(String element) {
        if (!set.contains(element)){
            set.add(element);
            numberOfElements+=1;
            return true;
        }
    return false;
    }

    public int getNumberOfElements(){
        return this.numberOfElements;
    }

    public boolean contains(String element) {
        for (Object object : set){
            if(element == object) return true;
        }
        return false;
    }

    public boolean remove(String element) {
        if (set.contains(element)){
            set.remove(element);
            numberOfElements -= 1;
            return true;
        }
        return false;
    }

    public void clear() {
        set.clear();
        numberOfElements = 0;
    }

    public String[] toArray() {
        return set.toArray(new String[0]);
    }

    private int numberOfElements;
    private ArrayList<String> set = new ArrayList<>();
}
