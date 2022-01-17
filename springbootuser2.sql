use springbootclass2;
drop table board_table;
drop table comment_table;
select * from board_table;
select * from comment_table;

insert into comment_table(comment_contents, comment_write, board_id)
	values('디비에서내용', '디비에서작성자', 1);
    
commit;


