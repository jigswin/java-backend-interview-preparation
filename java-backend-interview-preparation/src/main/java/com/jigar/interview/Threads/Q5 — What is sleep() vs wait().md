# Threads Q5 — What is sleep() vs wait()?

## sleep()

`sleep()` thread ko **specified time ke liye pause** karta hai.

Thread.sleep(5000);

→ 5 seconds wait
→ Uske baad thread dobara execution ke liye ready.


### Real Example

Payment API ko 2 sec baad retry karna:

Thread.sleep(2000);

→ Thread 2 sec pause.


## wait()

`wait()` thread ko **kisi condition / doosre thread ke signal ka wait** karata hai.

Example:

Thread A
→ wait()

Thread B
→ notify()

Thread A
→ Continue


## Main Difference

sleep()
→ Time-based waiting

wait()
→ Notification/condition-based waiting


### Important Point

`sleep()` generally **lock release nahi karta**.

`wait()` object ka monitor/lock **release karta hai** aur notify/notifyAll ya timeout ke baad continue karta hai.

`wait()` ko synchronized context / monitor ke saath use karna hota hai.


## Real Example

### sleep()

"5 seconds ruk jao."

### wait()

"Jab tak doosra thread signal na de,
main wait karta hoon."


## Interview Answer

"`sleep()` pauses the current thread for a specified amount of time and does not release the monitor lock. `wait()` is used for thread coordination; it releases the object's monitor and waits until notification or timeout."


## Easy Memory

sleep()
→ "TIME ka wait"


wait()
→ "SIGNAL ka wait"


sleep()
→ Lock release nahi


wait()
→ Lock release