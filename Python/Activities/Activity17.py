import pandas
dataFrame = pandas.read_excel('userCredentials.xlsx')
print(dataFrame)
dataFrame.to_csv('credentialSample.csv')