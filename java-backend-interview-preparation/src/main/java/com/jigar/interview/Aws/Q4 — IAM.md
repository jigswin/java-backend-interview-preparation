# AWS Q4 — IAM

## IAM kya hai?

IAM = Identity and Access Management

AWS resources ko:

→ Kaun access kar sakta hai?
→ Kya access kar sakta hai?

ye control karta hai.


## Real Example

Hamare AWS me:

EC2
S3
RDS


Developer ko:

EC2 → Access ✅
S3 → Access ✅
RDS → Access ❌


IAM decide karega ki kis user/service ko
kaunsi permission milegi.


## Main Components

### User

Individual person/account.

Example:

developer-jigar


### Group

Multiple users ka collection.

Example:

Developers

Is group ko EC2 access diya,
to group ke users ko permission mil sakti hai.


### Role

AWS resources/services ko permissions dene ke liye
bahut important.

Example:

EC2
↓
IAM Role
↓
S3 Access


EC2 application S3 se files access kar sakti hai
without hardcoding AWS credentials.


### Policy

Permissions ka actual rule/document.

Example concept:

Allow:
s3:GetObject


Meaning:

S3 object read karne ki permission.


## Real Spring Boot Example

Spring Boot application
↓
EC2
↓
IAM Role
↓
S3

Application ko S3 access chahiye.

Best practice:

❌ Code me AWS Access Key hardcode mat karo.

✅ EC2 ko IAM Role attach karo.


## Authentication vs Authorization

Authentication:

"Who are you?"


Authorization:

"What are you allowed to do?"


IAM mainly identity + permission management
provide karta hai.


## Interview Answer

"IAM is used to securely manage identities and permissions in AWS. Users, groups and roles can be assigned policies that define what resources and actions they are allowed to access. For applications running on EC2, I would prefer an IAM role instead of hardcoding AWS credentials."


## Easy Memory

IAM
→ Access Control


User
→ Person


Group
→ Users ka collection


Role
→ AWS service/application ko permission


Policy
→ Permission rules


Best Practice:
IAM Role > Hardcoded Credentials