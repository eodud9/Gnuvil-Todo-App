const todos = [
  { id: 1, title: "Eat Chicken" },
  { id: 2, title: "Drink Coke" },
  { id: 3, title: "Study Web Development" },
];

function App() {
  return (
    <div className="w-full min-h-screen bg-stone-100 flex flex-col items-center p-10 font-sans">
      {/* 타이틀 영역 */}
      <h1 className="text-5xl font-black text-stone-800 mb-10 tracking-tight">Your To Do</h1>

      <div className="w-full max-w-md flex flex-col gap-5">
        {/* 할 일 추가 영역 */}
        <div className="flex gap-3 items-center bg-white p-2 rounded-lg shadow-md border border-stone-200">
          <input
            type="text"
            placeholder="Add a new task"
            className="flex-1 px-4 py-2 outline-none text-stone-700 bg-transparent"
          />
          <button
            type="button"
            className="bg-stone-800 hover:bg-stone-700 cursor-pointer text-white w-10 h-10 rounded-xl transition-all flex items-center justify-center shadow-md"
          >
            <span className="text-2xl mb-1">+</span>
          </button>
        </div>

        {/* 할 일 목록 영역 */}
        <ul className="mt-10 space-y-3">
          {todos.map((t) => (
            <li
              key={t.id}
              className="group w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-2xl flex items-center justify-between shadow-md"
            >
              <div className="flex items-center gap-4">
                <input type="checkbox" className="w-5 h-5 accent-stone-800 cursor-pointer" />
                <p className="text-stone-600 font-medium group-hover:text-stone-900">{t.title}</p>
              </div>
              <button className="text-stone-300 hover:text-red-700 transition-colors font-bold pr-1 cursor-pointer">
                X
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;
