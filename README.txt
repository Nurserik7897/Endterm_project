Topic of the project is Online Survey Service. Aim of the program to take answers of users and count their responses. 
First functionality of the project is loggining. User can login as admin if he knows login and password of admin or login 
as usual respondent. If user has not account yet, he can choose option register, which will allow to user create account 
by inputting login and password. In addition, user can respond as anonim respondent. Admin able to create question and 
writes exactly 4 options of answer. Also he can see how many people answered on certain question. 

Class Answer stores parameters and constructors of answer. Parameters of this class are id , userid, questionid, answer.
Classes Question and User also stores parameters and constructors.

SurveyController takes values from repositories and  transfer it to certain method.

IDB and SurveyDatabase connects database to program by reference with username and password.

AnswerRepository includes methods that connected to answer. These methods are getAllAnswers and createAnswer. First method 
gets data from database, second conversely inputs data to the database.

UserRepository and QuestionRepository includes methods connected to user and question respectively.

Main class just reference to SurveyFrontEnd. SurveyFrontEnd describes interaction between program and user, so there
written menu with options and methods which are trigger depending on the option that user choose.

 