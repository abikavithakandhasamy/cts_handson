import React from "react";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

import { books, blogs, courses } from "./Data";

function App() {

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (

    <div style={{ display: "flex", justifyContent: "space-around" }}>

      {showBooks ? <BookDetails books={books} /> : null}

      {showBlogs ? <BlogDetails blogs={blogs} /> : null}

      {showCourses ? <CourseDetails courses={courses} /> : null}

    </div>

  );

}

export default App;