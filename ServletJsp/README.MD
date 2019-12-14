Lưu ý

a. 
> Nêu trường hợp bị lỗi như sau FAIL - Unable to delete [F:\apache-tomcat-7.0.33\webapps\balaji]. The continued presence of this file may cause problems."
>*  Windown or Linux khóa resources nó trỏ đến > ko thể build mới lại được
>* Gặp trong lúc deploy code mới, debug mode
>* **Fix:**  thêm  \<Context antiResourceLocking="true"> vào context.xml

b. 
> Khi xử lý ảnh cần chỉ rõ nơi đến của ảnh + loại ảnh, nếu ko có thì ko hiện thị được

c.