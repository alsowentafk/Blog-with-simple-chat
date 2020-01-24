saveGame(game: Game, fileToUpload: File) {
    const endpoint = 'http://localhost:8080/api/v1';
    const formData: FormData = new FormData();
    formData.append("file", fileToUpload);
    formData.append("object", JSON.stringify(game));
    this.httpClient
      .post(endpoint, formData).subscribe((val) => {
      console.log(val);
    });
    return false;
  }