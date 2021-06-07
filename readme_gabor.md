
# Todo Application

Todo application backend for H2G frontend mentees.


## Installation

### Docker innstallation
* https://www.docker.com/get-started
* download and install *docker desktop*
* Afer restart, docker may ask you to install WSL2 Linux kernel
    * do it, follow the link and the 1. point of the instructions

### Startup
```bash
docker build -t todo ./backend
docker container run -p 8080:8080 --name todo todo
```
Listening on `http://localhost:8080`.


## Usage/Examples

```javascript
fetch('http://localhost:8080/api/todo')
    .then(res => res.json())
    .then(todos => console.log(todos));
```


## API Reference

#### Get all todos

```http
  GET /api/items
```

#### Get todo

```http
  GET /api/todo/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of todo to fetch |

#### Remove todo

```http
  DELETE /api/todo/${id}
```

| Parameter | Type     | Description                        |
| :-------- | :------- | :--------------------------------- |
| `id`      | `string` | **Required**. Id of todo to delete |

#### Save todo

```http
  POST /api/todo
```

```typescript
type Todo = {
    title:  string,
    isDone: boolean
};
```

| Parameter      | Type   | Description                |
| :------------- | :----- | :------------------------- |
| `request body` | `Todo` | **Required**. Todo to save |

#### Update todo

```http
  PUT /api/todo/${id}
```

```typescript
type Todo = {
    title?:  string,
    isDone?: boolean
};
```

| Parameter      | Type     | Description                        |
| :------------- | :------- | :--------------------------------- |
| `id`           | `string` | **Required**. Id of todo to update |
| `request body` | `Todo`   | **Required**. Updated todo         |
