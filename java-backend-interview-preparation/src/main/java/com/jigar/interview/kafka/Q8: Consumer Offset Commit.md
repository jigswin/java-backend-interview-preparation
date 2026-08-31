# KAFKA — Q8: Consumer Offset Commit

## 1. Offset Commit kya hota hai?

Consumer ko Kafka ko batana hota hai:

"Main yahan tak messages process kar chuka hoon."

Is progress ko record karna:

→ Offset Commit


Example:

Partition 0

Offset 0 → Order 101 ✅
Offset 1 → Order 102 ✅
Offset 2 → Order 103 ✅
Offset 3 → Order 104


Consumer ne Offset 0,1,2 process kar liye.

Committed position:

→ Offset 3 ke around next processing position


Consumer restart hone par Kafka committed
position se processing resume kar sakta hai.


# 2. Auto Commit

Kafka consumer automatically offsets commit kar sakta hai.

Example:

enable.auto.commit=true


Consumer:

Read message
   ↓
Process
   ↓
Auto commit according to configuration


### Problem

Suppose:

Message read hua
   ↓
Offset commit ho gaya
   ↓
Business processing fail ❌


Ab consumer restart kare:

Kafka sochega:
"Ye message already processed hai."


Message dobara process nahi ho sakta.

→ Message loss ka risk


# 3. Manual Commit

Application khud decide karti hai ki
message successfully process hone ke baad
offset commit karna hai.


Flow:

Read
 ↓
Process
 ↓
Success?
 ↓
YES
 ↓
Commit Offset


Agar processing fail:

Read
 ↓
Process
 ↓
FAIL ❌
 ↓
Offset commit nahi


Restart/retry ke according message dobara process
ho sakta hai.


# 4. Real-World Payment Example

Kafka:

PaymentSuccess(P1001)


Consumer:

1. Message read
2. Payment record update
3. Database transaction successful
4. Offset commit


Flow:

Kafka
 ↓
Consumer
 ↓
Update DB
 ↓
Success ✅
 ↓
Commit Offset


Ye approach message processing ko
business success ke saath align karne me help karti hai.


# 5. At-Least-Once Connection

Manual/appropriate offset handling se
at-least-once processing achieve karna common hai.

Agar:

DB update successful
BUT
Offset commit fail


To same message dobara aa sakta hai.


Example:

Payment P1001
   ↓
DB update ✅
   ↓
Offset commit ❌
   ↓
Consumer restart
   ↓
P1001 again


Isliye consumer ko:

→ Idempotent

banana important hai.


# 6. Duplicate Handling

Consumer:

Payment ID = P1001


Check:

Already processed?
    |
    ├── YES → Ignore
    |
    └── NO  → Process
               ↓
             Save


Database me unique constraint / processed-event table
jaise approaches use kiye ja sakte hain.


# 7. Auto Commit vs Manual Commit

Auto Commit
→ Kafka automatically offset commit karta hai
→ Easy
→ Incorrect timing par commit hone ka risk


Manual Commit
→ Application control karti hai
→ Processing success ke baad commit kar sakte hain
→ More control


# 8. Real-World Recommendation

Important business events:

Payment
Order
Inventory


In cases me offset handling carefully design karna chahiye.

Blindly auto-commit par depend nahi karna chahiye.


## 9. Interview Answer

"Offset commit records the consumer's progress in a Kafka partition. With auto commit, offsets are committed automatically based on consumer configuration. With manual acknowledgement/commit, the application can coordinate offset acknowledgement with successful processing. If processing succeeds but the offset isn't committed, the message may be processed again, so consumers should be designed to handle duplicates safely."


## Easy Memory

Read
 ↓
Process
 ↓
Success
 ↓
Commit


❌ Process fail
→ Don't consider it successfully processed


DB Success
+
Commit Failure
→ Duplicate possible


Duplicate possible
→ Idempotent Consumer