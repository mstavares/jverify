# Welcome to jverify

jverify is a service developed to support [WalliD](https://wallid.io) protocol on Portuguese Citizenship Card KYCs. In order to accomplish this task, this service uses a library called [jkyc](https://github.com/mstavares/jkyc). This library is encharged to perform the user’s identity verification.

## Build
To build a new jar, we must run the following command at the project root.

```unix
mvn package spring-boot:repackage
```

## Run
The API uses java spring-boot which is running inside of a docker container, in order to run the servide we just need to run that docker image using its docker-compose.

```docker
docker-compose up

```

## / request example (POST)
The route which is used to verifiy a certain identity / and uses application/json as content-type. This route received on his body the DataID structure previously defined an published [DataID](https://github.com/walliDprotocol/wallid-MyEtherID/blob/master/test/DataId_Test_Card.json) by WalliD protocol.

### [OK] example response

```json
{
    "verificationSuccessful": true,
    "reason": null
}
```

### [Error] Revoked Certificate example response

```json
{
    "verificationSuccessful": false,
    "reason": "Certificate status is not good"
}
```

### [Error] Expired Certificate example response

```json
{
    "verificationSuccessful": false,
    "reason": "NotAfter: Tue Feb 27 00:00:00 UTC 2018"
}
```
### [Error] Expired Certificate example response

```json
{
    "verificationSuccessful": false,
    "reason": "NotAfter: Tue Feb 27 00:00:00 UTC 2018"
}
```

### [Error] Expired Certificate example response

```json
{
    "verificationSuccessful": false,
    "reason": "NotAfter: Tue Feb 27 00:00:00 UTC 2018"
}
```

### [Error] Invalid user's identity attributes

```json
{
    "verificationSuccessful": false,
    "reason": "Identity verification failed."
}
```

### [Error] Invalid user's address attributes

```json
{
    "verificationSuccessful": false,
    "reason": "Address verification failed."
}
```

## Configuration
The API has a configuration file (config.properties), this file has 3 configurable optons:
*  keystorePath -> is the keystore file path where the chain path certificates are placed. These certficates are encharged to verify the user's certificates. 
*  keystorePassword -> is the keystore password

There is already available a keystore which contains all those certificates. In any case, you are able to build your own keystore and use it.

```properties
keystorePath = <keystore file path>
keystorePassword = <keystore password>
```
