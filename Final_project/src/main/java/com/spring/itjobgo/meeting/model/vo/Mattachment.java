package com.spring.itjobgo.meeting.model.vo;

import java.sql.Date;

public class Mattachment {

		private int mattachmentNo;
		private int pboardSq;
		private String originalFilename;
		private String renamedFilename;
		private Date uploadDate;
		private String status;
		public int getMattachementNo() {
			return mattachmentNo;
		}
		public void setMattachementNo(int mattachmentNo) {
			this.mattachmentNo = mattachmentNo;
		}
		public int getPboardSq() {
			return pboardSq;
		}
		public void setPboardSq(int pboardSq) {
			this.pboardSq = pboardSq;
		}
		public String getOriginalFilename() {
			return originalFilename;
		}
		public void setOriginalFilename(String originalFilename) {
			this.originalFilename = originalFilename;
		}
		public String getRenamedFilename() {
			return renamedFilename;
		}
		public void setRenamedFilename(String renamedFilename) {
			this.renamedFilename = renamedFilename;
		}
		public Date getUploadDate() {
			return uploadDate;
		}
		public void setUploadDate(Date uploadDate) {
			this.uploadDate = uploadDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		} 
		public Mattachment() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Mattachment [mattachmentNo=" + mattachmentNo + ", pboardSq=" + pboardSq + ", originalFilename="
					+ originalFilename + ", renamedFilename=" + renamedFilename + ", uploadDate=" + uploadDate
					+ ", status=" + status + "]";
		}
		public Mattachment(int mattachmentNo, int pboardSq, String originalFilename, String renamedFilename,
				Date uploadDate, String status) {
			super();
			this.mattachmentNo = mattachmentNo;
			this.pboardSq = pboardSq;
			this.originalFilename = originalFilename;
			this.renamedFilename = renamedFilename;
			this.uploadDate = uploadDate;
			this.status = status;
		}
}
