# IRT-Item-Response-Theory

### What is it about

Item Response Theory is a mathematical model that estimates a student's ability based on the probability of getting each question of a test (applied in another contexts too).

### How it works

Since each question of test has three parameters that represents its difficulty, discrimination and the probability of getting randomly, a function called Item Characterist Curve (ICC) is setted up for each of them. This function describes the probability of getting the question according to student's ability.

Given two text files that contains all question's parameters and all student's answer for each one (provided by Professor Valdinei Freire da Silva), the program builds all ICC's and applies the ln-likelihood model. We can define the ln-likelihood model as l(θ|X) = ln[Pi Product of all CCI's], where θ is the student's ability and X is all his/her answers for questions. Thus, the value of θ where the function is maximum is the estimated student's ability.

### How to use

In terminal, just do 'java IRT.java studentsAnswFile.txt questionData.txt' to execute the program IRT.java, using those files as arguments. To use another data, follow the default files's pattern and change arguments in terminal.

### Result

Below is the ln-likelihood graphic for a specific student.

![image](https://user-images.githubusercontent.com/72703544/125284998-86692c00-e2f0-11eb-9982-a339c06d01a0.png)
