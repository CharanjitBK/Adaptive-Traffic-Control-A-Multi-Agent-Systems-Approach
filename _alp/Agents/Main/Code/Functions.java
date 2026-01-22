boolean checkDemandSwitch_NS(StopLine current_queue,StopLine opposing_queue1,StopLine opposing_queue2)
{/*ALCODESTART::1762971356643*/
    int qN = (stopLine == null ? 0 : stopLine.queueSize());
    int qS = (stopLine1 == null ? 0 : stopLine1.queueSize());
    int qE = (stopLine2 == null ? 0 : stopLine2.queueSize());
    
    int qNS = qN + qS;
    int qEW = qE;

    boolean demandSwitch = (time() >= lastPhaseChangeTime + MIN_GREEN &&
                            qEW > qNS * QUEUE_RATIO_THRESHOLD);
    boolean maxTimeSwitch = (time() >= lastPhaseChangeTime + MAX_GREEN);
    
    return demandSwitch || maxTimeSwitch;

/*ALCODEEND*/}

boolean checkDemandSwitch_EW(StopLine current_queue,StopLine opposing_queue1,StopLine opposing_queue2)
{/*ALCODESTART::1763026342087*/
int qN = (stopLine == null ? 0 : stopLine.queueSize());
int qS = (stopLine1 == null ? 0 : stopLine1.queueSize());
int qE = (stopLine2 == null ? 0 : stopLine2.queueSize());
	    
int qNS = qN + qS;
int qEW = qE;
boolean demandSwitch = (time() >= lastPhaseChangeTime + MIN_GREEN &&
	                            qNS > qEW * QUEUE_RATIO_THRESHOLD);
boolean maxTimeSwitch = (time() >= lastPhaseChangeTime + MAX_GREEN);
return demandSwitch || maxTimeSwitch;
	

/*ALCODEEND*/}

boolean checkDemandSwitch(StopLine q1,StopLine q2,StopLine q3)
{/*ALCODESTART::1766327351306*/
double Q_OPP_TOTAL = q2.queueSize() + q3.queueSize();
double Q_CURRENT = q1.queueSize();

boolean demandSwitch = (time() >= lastPhaseChangeTime + MIN_GREEN && 
                        Q_OPP_TOTAL > 0 && 
                        Q_OPP_TOTAL > Q_CURRENT * QUEUE_RATIO_THRESHOLD);

boolean maxTimeSwitch = (time() >= lastPhaseChangeTime + MAX_GREEN);

return demandSwitch || maxTimeSwitch;
/*ALCODEEND*/}

double getAvgDelayFixed()
{/*ALCODESTART::1766605382016*/
if (carsFinishedFixed > 0) {
    return totalDelayFixed / carsFinishedFixed;
} else {
    return 0;
}
/*ALCODEEND*/}

double getAvgDelayAdaptive()
{/*ALCODESTART::1766605411613*/
if (carsFinishedAdaptive > 0) {
    return totalDelayAdaptive / carsFinishedAdaptive;
} else {
    return 0;
}
/*ALCODEEND*/}

double getThroughput()
{/*ALCODESTART::1766605698893*/
double hours = time(HOUR);
if (hours > 0) {
    return isAdaptive ? (carsFinishedAdaptive / hours) : (carsFinishedFixed / hours);
} else return 0;
/*ALCODEEND*/}

