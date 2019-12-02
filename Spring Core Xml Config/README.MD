##Cấu hình Spring core; context sử dụng XML
I. **Tools & công nghệ sử dụng**

    * Spring Context 5.2.0.RELEASE
    * JDK 1.8 or later
    * Maven 3.6.2
    * IDE InteliiJ any version
    
II. **Bước triển khai**

    1. Tạo Maven project application
    2. Tạo packages cần thiết trong /src/main/java
    3. Tạo clazz trong gói tương ứng
    4. Tạo file xml cấu hình trong /resource
    5. Run project trên Intellij

III. **Chi tiết**
1. Tạo Maven project application:
    * New Project > Maven (Project SDK chắc chắn hiện version java) > Next
	* Điền GroupId, ví dụ: demo.springcore
	* Điền ArtifactId, ví dụ: demo.config.xml > Next
	* Không nên tạo tên có kí tự đặc biệt như: * @ " ' > < $ % ^ etc  ... tránh lỗi về sau
	* Tên project mặc định tạo từ ArtifactId
	* Chọn nơi lưu project > Next
	* Tạo thành công project có cấu trúc:
		* _/src/main/java; src/main/resources_
		* _/pom.xml_
	    * _other files_
2. Tạo packages cần thiết trong *__/src/main/java__*
    * theo cấu trúc như  _[tên_nước].[tên_tổ_chức].[tên_dự_án]_ >  để dễ tổ chức & theo chuẩn
    * ví dụ: com.hivetech.springcore (a) 
    * tạo package xml trong (a) > com.hivetech.springcore.xml (b)
    * tạo package app, context, bean trong (b)
3. Tạo clazz trong gói tương ứng
    * **app:** AppRunner.java [có main()] > dùng để chạy chương trình
    * ~~**context:** SpringXmlAppContext > tạo context để khởi tạo, cấu hình, lắp ráp bean từ file xml~~
    * **bean:** A.java, B.java, C.java > tạo các clazz cần dùng & đăng kí nó là bean
    * > :+1: _ mục đích chia như vậy để dễ quản lý, clazz có nhiệm vụ tương ứng cho cùng một gói. Dễ tìm kiếm, quản lý,.._
4. Tạo file _xml_ cấu hình trong **/resources**
    * phần này ta cấu cấu hình theo xml, ta nên đặt tên như sau > **applicationContext.xml**
5. Run project trên Intellij
    * AppRunner.java > chọn [green >] cạnh trái main() > Run 'AppRunner.main()' or Vào AppRunner.java **ctrl + shift + f10**
     
6. Một số lỗi thường gặp
    * Sai tên clazz trỏ tới thuộc tính *"class"* trong thẻ **\<bean>**
    * tên field trong .java # với thuộc tính name trong thẻ **\<property>**
    * thuộc tính ref tham chiếu tới bean sai  trong thẻ **\<property>**
    * ko tìm được file xml cấu hình
    * dùng context sai
    * etc..
:apple:
     
    
            
