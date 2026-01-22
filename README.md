# Adaptive Traffic Control A Multi Agent Systems Approach Against A Fixed Cycle Control
This project presents a comparative study between Fixed-Cycle Control and an Autonomous Multi-Agent System (MAS) for urban traffic optimization. The core objective is to evaluate how decentralized, Reactive Agents perform against static baseline models.
##### The Competitive Approach
This study contrasts two distinct paradigms of intersection control to evaluate their performance under stress:
#####  Baseline (Fixed): 
A "blind" open-loop system that operates on pre-defined temporal intervals. It lacks environmental perception and cannot adapt to fluctuating traffic densities.
##### MAS (Adaptive): 
A closed-loop Feedback Architecture where the controller acts as an autonomous agent. This agent continuously samples the environment via sensors, processes the data through an Exponential Moving Average (EMA) filter to mitigate stochastic noise, and dynamically recalculates green-light durations in real-time.
### 1. Agent Architecture
The Traffic Light Agents are designed using a Hybrid Reactive–Deliberative approach:
##### Perception:
Agents perceive the environment using localized queue sensors:
stopLine.queueSize()
##### Internal State (Memory): 
Exponential Moving Average (EMA) smooths incoming sensor data
Prevents erratic decisions caused by stochastic vehicle arrivals
##### Reasoning:
Agents compute the fair share of green time
Based on relative demand between competing approaches
##### Decision Logic (Java)
The agent calculates the green duration using:
G_duration = max(G_min, min(G_max, (Q_smoothed_target / Q_total) * (G_min + G_max)/2))

### 2. Key MAS Concepts Implemented
#### BDI Framework:
##### Beliefs: Real-time queue lengths and historical smoothed averages
##### Desires: Minimize average system-wide travel delay and maximum throughput
##### Intentions: Active states in the traffic signal statechart (e.g., NS_Green, EW_Yellow)
#### Autonomy 
Each intersection operates without a centralized controller
Decisions are made solely from local perception
#### Social Welfare: 
Maximizes global throughput
Balances fairness for minor approaches under asymmetric demand

### 3. Performance Metrics
The simulation tracks the following Key Performance Indicators (KPIs):
##### Average Delay (Fixed vs Adaptive): Mean waiting time per vehicle
##### Throughput: Vehicles processed per hour
##### Real-time Traffic Queue: Number of vehicles passing through the lane 

### 4. How to Run
###### Install AnyLogic 8.x
###### Clone or download this repository
###### Open Road Traffic11.alpx
###### Run the Main experiment
###### Toggle the isAdaptive boolean at runtime and compare:
###### Fixed-time control
###### Reactive multi-agent control
