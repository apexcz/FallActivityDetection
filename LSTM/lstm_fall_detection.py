import math
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# LSTM for sequence classification in the fall dataset
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import LSTM
from keras.layers import Dropout
from keras.preprocessing import sequence

from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.metrics import precision_recall_curve
from sklearn.metrics import average_precision_score
from sklearn.metrics import f1_score

    
def plot_confusion_matrix(conf_arr,title='Confusion matrix'):
    norm_conf = []
    for i in conf_arr:
        a = 0
        tmp_arr = []
        a = sum(i, 0)
        for j in i:
            tmp_arr.append(float(j)/float(a))
        norm_conf.append(tmp_arr)

    fig = plt.figure()
    plt.clf()
    plt.title(title)
    ax = fig.add_subplot(111)
    ax.set_aspect(1)
    res = ax.imshow(np.array(norm_conf), cmap=plt.cm.jet, 
                    interpolation='nearest')

    width, height = conf_arr.shape

    for x in range(width):
        for y in range(height):
            ax.annotate(str(conf_arr[x][y]), xy=(y, x), 
                        horizontalalignment='center',
                        verticalalignment='center')

    cb = fig.colorbar(res)
    alphabet = ["Fall", "Non Fall"]
    plt.xticks(range(width), alphabet[:width])
    plt.yticks(range(height), alphabet[:height])
    plt.savefig('confusion_matrix.png', format='png')
    
#falls = df[df['isFall']==1]

# fix random seed for reproducibility
np.random.seed(7)


train_file = 'Joon_wrist.csv'
test_file = 'Boyu_wrist.csv'
train_waistfile = 'Joon_waist.csv'
test_waistfile = 'Boyu_waist.csv'
 
#cols = train_df.columns.values.tolist()
cols = ['max_x','max_y','max_z','min_x','min_y','min_z','mean_x','mean_y','mean_z','var_x','var_y','var_z']
input_dim = 12
output_dim = 1
memory_units = 100
batch_size = 1
epochs = 10

train_df = pd.read_csv(train_file,index_col=0)
y_train = train_df['isFall']
#X_train = train_df.drop(['isFall'],axis=1)
X_train = train_df[cols]

train_waist_df = pd.read_csv(train_waistfile,index_col=0)
y_waist_train = train_waist_df['isFall']
X_waist_train = train_waist_df[cols]

y_train = pd.concat([y_train,y_waist_train])
X_train = pd.concat([X_train,X_waist_train])


test_df = pd.read_csv(test_file,index_col=0)
y_test = test_df['isFall']
X_test = test_df[cols]

test_waist_df = pd.read_csv(test_waistfile,index_col=0)
y_waist_test = test_waist_df['isFall']
X_waist_test = test_waist_df[cols]

y_train = pd.concat([y_test,y_waist_test])
X_train = pd.concat([X_test,X_waist_test])

X_train= np.reshape(X_train.as_matrix(),(X_train.shape[0],X_train.shape[1],1))
X_test= np.reshape(X_test.as_matrix(),(X_test.shape[0],X_test.shape[1],1))

model = Sequential()
model.add(LSTM(memory_units, batch_input_shape=(batch_size, input_dim, 1), stateful=True, dropout=0.5, recurrent_dropout=0.5))
model.add(Dense(64, activation='relu'))
model.add(Dense(1, activation='sigmoid'))

model.compile(loss='binary_crossentropy',
              optimizer='rmsprop',
              metrics=['accuracy'])

print(model.summary())

lstm = model.fit(X_train, y_train,
          epochs=epochs,
          batch_size=batch_size)

scores = model.evaluate(X_test, y_test, batch_size=batch_size)

pred = model.predict_classes(X_test, batch_size=1)
conf_mat = confusion_matrix(y_test, pred)
print(conf_mat)

accuracy = (scores[1]*100)
precision, recall, _ = precision_recall_curve(y_test, pred)
average_precision = average_precision_score(y_test, pred)
f1_score = f1_score(y_test, pred, average='weighted') 

print("Accuracy: %.2f%%" % accuracy)
print("precision = ", precision, len(precision))
print("recall = ", recall,len(recall))
print("average_precision = ",average_precision)
print("f1_score = ",f1_score)
plot_confusion_matrix(conf_mat,"Waist data Confusion matrix")
plt.show()

#print(classes)
# plot metrics

#plt.plot(lstm.history['acc'])
#plt.show()
