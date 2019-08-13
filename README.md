The application uses several data mining algorithms on a data set consisting of - scores of 100
countries based on various parameters namely Voice and Accountability, Political stability and
Violence, Government Effectiveness, Regulatory Quality, Rule of Law and Control of Corruption for
the year 1996.
The application gets this dataset from PostgreSQL and implements various algorithms on the data.
The following data mining algorithms are implemented by the application:
1. Clustering using Kmean algorithm
2. Association using Apriori algorithm
3. Classification using Naïve Bayesian algorithm
4. Prediction using Regression algorithm
The application, a dynamic web project was developed using Eclipse IDE.
The project was built on the MVC model- Model, View and Controller.
The Model brings the data from the database every time the application is loaded.
The View contains the jsp webpages. These jsp webpages are used to take input from user and
display the result.
The Controller class controls the flow of data and the pages displayed to the user. It is a java class
which controls the flow of the application.

Prediction:
The application finds the line of regression for two variables namely, Political Stability Violence
(Dependent Variable) and Voice Accountability (Independent Variable) and displays it to the user.
It accepts value of Voice Accountability from the user and predicts the value of Political Stability
Violence using the line of regression.

Clustering:
The data is divided into two clusters using the kmean algorithm. The clusters are formed based on
the Euclidean distance between Voice Accountability and Government Effectiveness. The countries
which are close in terms of the distance belong to the same cluster.

Classification:
The value of Voice Accountability, Government Efficiency and Control of Corruption are taken as
input from the user. Depending on the values, a class (good or bad) is allotted using Naïve Bayesian
Classification Algorithm.

Association
Apriori algorithm is implemented on the data-set and the association rules are found. The value of
minimum support is accepted from the user and the Strong Association Rules are displayed for the
entered value.
