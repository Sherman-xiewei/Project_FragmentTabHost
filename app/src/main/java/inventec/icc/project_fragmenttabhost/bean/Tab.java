package inventec.icc.project_fragmenttabhost.bean;

public class Tab {
    private int title;
    private int ico;
    private Class fragment;

    public Tab(int title, int ico, Class fragment) {
        this.title = title;
        this.ico = ico;
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
