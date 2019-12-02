##Spring Web + JSP + Servlet
I. **Tools & công nghệ sử dụng**

    * Spring Context, Web 5.2.0.RELEASE
    * Servlet 4.0, Jstl 1.2
    * JDK 1.8 or later
    * Maven 3.6.2
    * Apache Tomcat 8+
    * IDE InteliiJ any version
    * MariaDB 9+
    
>   Fix BELLOW later
>
II. **Bước triển khai**

    1. Tạo Maven project application
    2. Tạo packages cần thiết trong /src/main/java
    3. Tạo clazz trong gói tương ứng
    4. Tạo file xml cấu hình trong /resources
    5. Restore DB 
    6. Run project trên Intellij

III. **Chi tiết**
> **Ý tưởng:** Mục tiêu phần này để kết nối tới DB bất kì, t cần lấy thông số cần thiết để kết nối tới nó.
>
> *Ví dụ:* url, driver, host, user-name, passowrd...
>
> **Cách lấy params từ trong project:** :squirrel:
> ****
> * *Cấu hình từ xml > đọc thông số db từ file yaml, properties > lưu vào POJO* > Sử dụng POJO để tạo kết nối & truy vấn
> 
> * *Dùng annotation để đọc từ file lưu thông số db yaml, properties > ...*
>****
1. Tạo Maven project application:
    * New Project > Maven (Project SDK chắc chắn hiện version java) > Next
	* Điền *GroupId*, ví dụ: demo.springcore
	* Điền *ArtifactId*, ví dụ: demo.config.mixing > Next
	* Không nên tạo tên có kí tự đặc biệt như: * @ " ' > < $ % ^ etc  ... tránh lỗi về sau
	* Tên project mặc định tạo từ ArtifactId
	* Chọn nơi lưu project > Next
	* Tạo thành công project có cấu trúc:
		* _/src/main/java; src/main/resources_
		* _/pom.xml_
	    * _other files_
2. Tạo packages cần thiết trong *__/src/main/java__*
    * cấu trúc: _[tên_nước].[tên_tổ_chức].[tên_dự_án]_ >  để dễ tổ chức & theo chuẩn
    * ví dụ: 
    > com.hivetech.demoparams_v1: lấy data từ file .properties  (a1)
    >
    > com.hivetech.demoparams_v2: lấy data từ file .yaml  (a2) 
    * tạo packages  trong (a1) & (a2):
        * model: là POJOs        
        * context: khai báo beans bằng annotation
        * connectionutil: xử  lý kết nối db
3. Tạo clazz trong gói tương ứng
    * AppRunner.java [có main()] > dùng để chạy chương trình
    * **/src/main/resources:**
        * *mariadb.properties:* lưu trữ các cấu hình tới mariadb dạng **Key-Value**
        * *mariadb_v2.yaml:* lưu trữ các cấu hình tới mariadb dạng **Tree key-value**
        * *db-config.xml:* đăng kí & kích hoạt bean, mapping dữ liệu từ file propertise & yaml vào property tương ứng
    * *Logger* dùng để log các bước xử lý logic, lỗi, cảnh bảo,.. của chương trình thay vì dùng *System.out.print*  :ok_hand:
    * > :+1: _ mục đích chia như vậy để dễ quản lý, clazz có nhiệm vụ tương ứng cho cùng một gói. Dễ tìm kiếm, quản lý,.._
    * >  :exclamation: dùng **\<context:component-scan/\>** để quét các bean được khai báo trong package chỉ định
4. Tạo file xml cấu hình trong /resources
5. Restore Database
    * file db có thể dùng chung cho **mysql, mariadb**
    * đăng nhập db: 
    * C:\Windows\System32>**mysql -u root -p**
    * điền mật khẩu của root > _Enter password: ****_
    * backup, sau khi đăng nhập gõ: **source d:\sample.sql**
    * mariadb tự động trỏ tới db vừa backup: MariaDB [classicmodels]>
    * hiện tables trong db: MariaDB [classicmodels]> **show tables;**
    > Result:  :heartpulse:
    >
     | Tables_in_classicmodels |
     |-------------------------|
     | customers               |
     | employees               |
     | offices                 |
     | orderdetails            |
     | orders                  |
     | payments                |
     | productlines            |
     | products                |
    > _8 rows in set (0.000 sec)_
    >
    > CSDL mẫu :metal: [here](http://www.mysqltutorial.org/mysql-sample-database.aspx), hoặc ở trong /mariadb   
6. Run project trên Intellij  :running:
    * AppRunner.java > chọn [green >] cạnh trái main() > Run 'AppRunner.main()' or Vào AppRunner.java **ctrl + shift + f10**     
7. Một số lỗi thường gặp  :trollface:
    * công nghệ ko tương thích với nhau
    * thiếu annotation
    * ko định nghĩa name space
    * các công nghệ ko tương thích về phiên bản
    * dùng context sai
    * dùng sai hoặc thiếu annotation   
    * nhiều bean implement cùng 1 interface, ko sử dụng **@Qualifier**
    * Injection sai kiểu
    * url kết nối db sai, sai port, sai driver, sai thư viện
    * etc..
> http://jaiswaltraining.com/Spring/ch3.php   
     
    
            
