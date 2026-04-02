import { createBrowserRouter, Outlet, RouterProvider } from "react-router";
import TodoPage from "./pages/TodoPage";
import AuthPage from "./pages/AuthPage";
import Header from "./components/Header";
import LoginForm from "./components/LoginForm";
import SignupForm from "./components/SignupForm";

const router = createBrowserRouter([
  {
    path: "/",
    element: (
      <div className="w-full min-h-screen bg-stone-100">
        <Header />
        <div className="min-h-screen flex flex-col items-center justify-center p-20">
          <Outlet />
        </div>
      </div>
    ),
    children: [
      {
        path: "todos",
        element: <TodoPage />,
      },
      {
        path: "auth",
        element: <AuthPage />,
        children: [
          { path: "login", element: <LoginForm /> },
          { path: "signup", element: <SignupForm /> },
        ],
      },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
