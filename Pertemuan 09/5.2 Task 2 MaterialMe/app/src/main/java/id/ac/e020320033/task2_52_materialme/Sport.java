
package id.ac.e020320033.task2_52_materialme;

class Sport {
    private String title;
    private String info;
    private final int imageResource;

    Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }
    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }
}
