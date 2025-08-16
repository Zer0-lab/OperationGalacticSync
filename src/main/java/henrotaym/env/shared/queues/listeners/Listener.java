package henrotaym.env.shared.queues.listeners;

import henrotaym.env.shared.queues.events.Event;

public interface Listener<T extends Event> {
  public void listen(T event);
}
