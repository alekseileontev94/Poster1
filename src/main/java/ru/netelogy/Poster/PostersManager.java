package ru.netelogy.Poster;

public class PostersManager {

    private String[] posters = new String[0];
    private int limit;

    public PostersManager(int newLimit) {
        this.limit = newLimit;
    }

    public PostersManager() {
        this.limit = 5;
    }

    public void addNew(String newPoster) {
        String[] tmp = new String[posters.length + 1];
        System.arraycopy(posters, 0, tmp, 0, posters.length);
        tmp[tmp.length - 1] = newPoster;
        posters = tmp;
    }

    public String[] findAll() {
        return posters;
    }

    public String[] findLast() {
        int resultLength;
        if (posters.length < limit) {
            resultLength = posters.length;
        } else {
            resultLength = limit;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = posters[posters.length - 1 - i];
        }
        return tmp;
    }
}