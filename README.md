# Sensor Platform for Healthcare in a Residential Environment (SPHERE) Physical Activity Sensor Dataset
Uses classification algorithms such as Support Vector Machine (SVM), K-Nearest Neighbour (KNN), and Long Short-Term Memory (LSTM) to detect fall activities with data gotten from wearables. The sphere.WEAR.json file contains the raw data collected from the accelerometers.

## Abstract
The SPHERE dataset contains 20 physical activities performed by 2 actors wearing 2 wearables each. One wearable on the wrist and the other on the waist region. Each wearable serves as an accelerometer sensor and is uniquely identified with a unique id. The activities are:

1 - Fall
2 - Fall while wiggling hands
3 - Pick something on the floor
4 - Descend staircase
5 - Climb staircase
6 - Jump
7 - Kneel down
8 - Lie down
9 - Lie still on bed 
10 - Drop something on the floor
11 - Raise hand then put it down
12 - Run up stairs
13 - Run on flat ground
14 - Sit down properly
15 - Sit still
16 - Stand still
17 - Dive on the bed
18 - Dive on the sofa
19 - Try to keep balance
20 - Walk on flat ground

## Dataset Information
The raw data collected by the accelerometers is stored in Json format. Each item contains a unique id ($oid), an accelerometer id (uid), a time stamp ($date), a list (e) that contains six sets of acceleration values in three directions (x,y,z) and the time offsets (t), as well as 5 other attributes that are irrelevant for this study.
