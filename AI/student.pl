roll_no(ram, 001).
roll_no(shyam, 002).
roll_no(hanuman, 003).
roll_no(radha, 004).
roll_no(sonu, 005).
roll_no(monu, 006).
roll_no(tony, 007).
roll_no(sweety, 008).
roll_no(john, 009).
roll_no(ballu, 010).

student_type(ram, b_tech).
student_type(shyam, m_tech).
student_type(hanuman, m_tech).
student_type(radha, b_tech).
student_type(sonu, b_tech).
student_type(monu, mba).
student_type(tony, rs).
student_type(sweety, rs).
student_type(john, mba).
student_type(ballu, m_tech).

roll_no_of_branch(X,Y) :- student_type(Z,Y),roll_no(Z,X).
