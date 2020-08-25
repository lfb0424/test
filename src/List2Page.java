import java.util.ArrayList;
import java.util.List;

/**
 * @author lifubei
 * @date 2020/07/12 13:51
 */
public class List2Page<T> {
    private List<T> sourceList; // 大的集合，外界传入
    private int pageNum = 1; // 当前页号，外界传入
    private int pageSize = 2; // 每页条数，外界可以设定
    private List<T> pageList; // 小的集合，返回
    private int pageCount; // 页数
    private int recordCount; // 记录条数
    private int prePageIndex; // 上一页序号
    private int nextPageIndex; // 下一页序号
    private boolean firstPage; // 是否第一页
    private boolean lastPage; // 是否最后一页

    public void setPageNum(int pageNum) { // 每当页数改变，都会调用这个函数，筛选代码可以写在这里
        this.pageNum = pageNum;

        // 上一页，下一页确定
        prePageIndex = pageNum - 1;
        nextPageIndex = pageNum + 1;
        // 是否第一页，最后一页
        if (pageNum == 1) {
            firstPage = true;
        } else {
            firstPage = false;
        }
        if (pageNum == pageCount) {
            lastPage = true;
        } else {
            lastPage = false;
        }
        // 筛选工作
        pageList = new ArrayList<T>();
        for (int i = (pageNum - 1) * pageSize; i < pageNum
                * pageSize
                && i < recordCount; i++) {
            pageList.add(sourceList.get(i));
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public List<T> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<T> sourceList) {
        this.sourceList = sourceList;
        // 计算条数
        recordCount = sourceList.size();
        // 计算页数
        if (recordCount % pageSize == 0) {
            pageCount = recordCount / pageSize;
        } else {
            pageCount = recordCount / pageSize + 1;
        }

        // 筛选工作
        pageList = new ArrayList<T>();
        for (int i = (pageNum - 1) * pageSize; i < pageNum
                * pageSize
                && i < recordCount; i++) {
            pageList.add(sourceList.get(i));
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(ArrayList<T> pageList) {
        this.pageList = pageList;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getNextPageIndex() {
        return nextPageIndex;
    }

    public void setNextPageIndex(int nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
    }

    public int getPrePageIndex() {
        return prePageIndex;
    }

    public void setPrePageIndex(int prePageIndex) {
        this.prePageIndex = prePageIndex;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");


        List2Page<String> page = new List2Page<>();
        page.setPageNum(1);
        page.setPageSize(3);
        page.setSourceList(list);

        System.out.println("record:"+ page.getRecordCount());
        List<String> smallList = page.getPageList();
        for (String s : smallList) {
            System.out.println(s);
        }
    }
}
