roll_no(ram, s001).
roll_no(shyam, s002).
roll_no(hanuman, s003).
roll_no(radha, s004).
roll_no(sonu, s005).
roll_no(monu, s006).
roll_no(tony, s007).
roll_no(sweety, s008).
roll_no(john, s009).
roll_no(ballu, s010).

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

branch(ram, IT).
branch(shyam, ECE).
branch(hanuman, CSE).
branch(radha, ECE).
branch(sonu, IT).
branch(monu, IT).
branch(tony, ECE).
branch(sweety, IT).
branch(john, IT).
branch(ballu, ECE).

state(ram, UP).
state(shyam, MP).
state(hanuman, HP).
state(radha, Bihar).
state(sonu, AP).
state(monu, Delhi).
state(tony, Punjab).
state(sweety, UP).
state(john, UP).
state(ballu, Rajsthan).




# x=roll_no      y=type
roll_no_of_branch(X,Y) :- student_type(Z,Y),roll_no(Z,X).

