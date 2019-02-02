package com.jarik.library.controllers.payload;

public class UploadBookResponse {

    private String bookName;
    private String bookDownloadUri;
    private String fileType;
    private long size;

    public UploadBookResponse(String bookName, String bookDownloadUri, String fileType, long size) {
        this.bookName = bookName;
        this.bookDownloadUri = bookDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public String getBookDownloadUri() { return bookDownloadUri; }
    public void setBookDownloadUri(String bookDownloadUri) { this.bookDownloadUri = bookDownloadUri; }
    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }
    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }
}
