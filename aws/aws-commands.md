aws configure

aws ec2 run-instances \
    --image-id ami-03aefa83246f44ef2 \
    --count 1 \
    --instance-type t2.micro \
    --key-name my-key-cli \
    --security-group-ids sg-0513a9019ba54b8e8 \
    --subnet-id subnet-019d44505bb5b4a6e

 aws ec2 describe-instances

aws ec2 describe-vpcs

aws ec2 authorize-security-group-ingress

aws ec2 authorize-security-group-ingress \
    --group-id sg-0513a9019ba54b8e8 \
    --protocol tcp --port 22 \
    --cidr 0.0.0.0/0

aws ec2 describe-security-groups --group-ids sg-0513a9019ba54b8e8

aws ec2 create-key-pair \
    --key-name my-key-cli \
    --query 'KeyMaterial' \
    --output text > ~/.ssh/my-key-cli.pem

chmod 400 ~/.ssh/my-key-cli.pem

aws ec2 describe-subnets

 aws ec2 describe-instances \
    --filters "Name=instance-type,Values=t2.micro" \
    --query "Reservations[].Instances[].InstanceId"

aws ec2 describe-instances \
   --filters "Name=tag:Type,Values=Web Server with Docker"

aws ec2 describe-instances \
    --filters "Name=tag:Type,Values=Web Server with Docker"

aws iam create-group \
    --group-name MyGroupCli

aws iam create-user \
    --user-name MyUserCli

aws iam add-user-to-group \
    --user-name MyUserCli \
    --group-name MyGroupCli

aws iam get-group \
    --group-name MyGroupCli

aws iam attach-group-policy \
    --group-name MyGroupCli \
    --policy-arn arn:aws:iam::aws:policy/AmazonEC2FullAccess

aws iam list-attached-group-policies \
    --group-name MyGroupCli

aws iam list-policies \
    --query 'Policies[?PolicyName==`AmazonEC2FullAccess`]' \
    --output text

aws iam create-login-profile \
    --user-name MyUserCli \
    --password  P@ssword \
    --password-reset-required

aws iam get-user \
    --user-name MyUserCli

aws iam create-policy \
    --policy-name fullPwdPolicy \
    --policy-document file://fullPwdPolicy.json

aws iam attach-group-policy \
    --group-name MyGroupCli \
    --policy-arn arn:aws:iam::478941551825:policy/fullPwdPolicy

aws iam detach-group-policy \
    --group-name MyGroupCli \
    --policy-arn arn:aws:iam::478941551825:policy/fullPwdPolicy

aws iam delete-policy \
    --policy-arn arn:aws:iam::478941551825:policy/fullPwdPolicy

aws iam create-access-key \
    --user-name MyUserCli


export AWS_ACCESS_KEY_ID=
export AWS_SECRET_ACCESS_KEY=

 