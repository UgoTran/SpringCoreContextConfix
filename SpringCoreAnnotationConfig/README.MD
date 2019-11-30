##Cấu hình Spring core; context sử dụng Annotation
I. **Tools & công nghệ sử dụng**

    * Spring Context 5.2.0.RELEASE
    * JDK 1.8 or later
    * Maven 3.6.2
    * IDE InteliiJ any version
    
II. **Bước triển khai**

    1. Tạo Maven project application
    2. Tạo packages cần thiết trong /src/main/java
    3. Tạo clazz trong gói tương ứng
    4. Run project trên Intellij

III. **Chi tiết**
1. Tạo Maven project application:
    * New Project > Maven (Project SDK chắc chắn hiện version java) > Next
	* Điền *GroupId*, ví dụ: demo.springcore
	* Điền *ArtifactId*, ví dụ: demo.config.annotation > Next
	* Không nên tạo tên có kí tự đặc biệt như: * @ " ' > < $ % ^ etc  ... tránh lỗi về sau
	* Tên project mặc định tạo từ ArtifactId
	* Chọn nơi lưu project > Next
	* Tạo thành công project có cấu trúc:
		* _/src/main/java; src/main/resources_
		* _/pom.xml_
	    * _other files_
2. Tạo packages cần thiết trong *__/src/main/java__*
    * cấu trúc: _[tên_nước].[tên_tổ_chức].[tên_dự_án]_ >  để dễ tổ chức & theo chuẩn
    * ví dụ: com.hivetech.springcore (a) 
    * tạo package *annotation* trong (a) > com.hivetech.springcore.annotation (b)
    * tạo package app, context, bean trong (b)
3. Tạo clazz trong gói tương ứng
    * **app:** AppRunner.java [có main()] > dùng để chạy chương trình
    * **context:** SpringAnnotationAppContext > tạo context để khởi tạo, cấu hình beans
    * **bean:** A.java, B.java, C.java > tạo các clazz cần dùng & đăng kí nó là bean
    * > :+1: _ mục đích chia như vậy để dễ quản lý, clazz có nhiệm vụ tương ứng cho cùng một gói. Dễ tìm kiếm, quản lý,.._
4. Run project trên Intellij  :running:
    * AppRunner.java > chọn [green >] cạnh trái main() > Run 'AppRunner.main()' or Vào AppRunner.java **ctrl + shift + f10**     
5. Một số lỗi thường gặp  :trollface:
    * các công nghệ ko tương thích về phiên bản
    * dùng context sai
    * dùng sai hoặc thiếu annotation   
    * nhiều bean implement cùng 1 interface, ko sử dụng **@Qualifier**
    * Injection sai kiểu
    * etc..
   
     
    
            
