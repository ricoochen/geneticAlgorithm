package ga.test.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class smzq {

	public static class SampleThread implements Runnable {

		private int no;

		private int time;

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		SampleThread(int no, int time) {

			this.no = no;

			this.time = time;

		}

		@Override

		public void run() {

			System.out.println("No." + no + " start ID:" + Thread.currentThread().getId() + " 生命周期:" + time + " 现在时间:"
					+ sdf.format(Calendar.getInstance().getTime()));

			try {

				Thread.sleep(time * 1000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			System.out.println("No." + no + " end ID:" + Thread.currentThread().getId() + " 生命周期:" + time + " 现在时间:"
					+ sdf.format(Calendar.getInstance().getTime()));

		}

	}

	public static void main(String[] args) {

		final int MAX_THREADS = 3; // 定义线程数最大值

		ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

		for (int i = 0; i < 10; i++) {

			int no = i;

			int lifeTime = (int) (Math.random() * 9 + 1);

			executorService.submit(new SampleThread(no, lifeTime));

		}

		System.out.println("executor.shutdown();");

		executorService.shutdown();

	}

}