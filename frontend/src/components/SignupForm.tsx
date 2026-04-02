export default function SignupForm() {
  return (
    <form action="#" className="w-full max-w-2/3">
      <div className="flex flex-col ">
        <label htmlFor="email" className="mb-3 text-stone-600 font-medium">
          이메일
        </label>
        <input
          type="email"
          id="email"
          name="email"
          className="group w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-lg flex items-center justify-between shadow-md outline-none"
        />
      </div>
      <div className="flex flex-col my-5">
        <label htmlFor="password" className="mb-3 text-stone-600 font-medium">
          비밀번호
        </label>
        <input
          type="password"
          id="password"
          name="password"
          className="group w-full p-4 border border-stone-200 hover:border-stone-300 transition-colors rounded-lg flex items-center justify-between shadow-md outline-none"
        />
      </div>
      <button className="px-6 py-3 bg-stone-700 rounded-xl text-white font-bold cursor-pointer hover:bg-stone-600 transition-all active:scale-95">
        회원가입
      </button>
    </form>
  );
}
